package vn.edupiamath.firebaseclient.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import vn.edupiamath.core.utils.ConvertUtils;
import vn.edupiamath.firebaseclient.services.FirebaseClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static vn.edupiamath.core.utils.AppUtils.getFullStackTrace;

@Slf4j
@RequiredArgsConstructor
public class FirebaseClientImpl implements FirebaseClient {

    @Value("${spring.fire-base.base-url:https://fcm.googleapis.com/fcm}")
    private String firebaseBaseUrl;

    @Value("${spring.fire-base.server-key:}")
    private String firebaseServerKey;

    @Value("${spring.fire-base.project-id:570874220219}")
    private String projectId;

    @Value("${spring.fire-base.path.send:/send}")
    private String pathSend;

    @Value("${spring.fire-base.path.notification:/notification}")
    private String pathNotification;

    private final RestTemplate restTemplate;

    public Object createGroupNotification(String groupName, List<String> registrationIds) {
        Map<String, Object> createGroupData = new HashMap<>();
        createGroupData.put("operation", "create");
        createGroupData.put("notification_key_name", groupName);
        createGroupData.put("registration_ids", registrationIds);
        var url = firebaseBaseUrl + pathNotification;
        return postObject(createGroupData, url, projectId, firebaseServerKey);
    }

    @Override
    public Object addDeviceToGroup(String groupName, String notificationKey, List<String> registrationIds) {
        Map<String, Object> createGroupData = new HashMap<>();
        createGroupData.put("operation", "add");
        createGroupData.put("notification_key_name", groupName);
        createGroupData.put("notification_key", notificationKey);
        createGroupData.put("registration_ids", registrationIds);
        var url = firebaseBaseUrl + pathNotification;
        return postObject(createGroupData, url, projectId, firebaseServerKey);
    }


    @Override
    public Object removeDeviceFromGroup(String groupName, String notificationKey, List<String> registrationIds) {
        Map<String, Object> createGroupData = new HashMap<>();
        createGroupData.put("operation", "remove");
        createGroupData.put("notification_key_name", groupName);
        createGroupData.put("notification_key", notificationKey);
        createGroupData.put("registration_ids", registrationIds);
        var url = firebaseBaseUrl + pathNotification;
        return postObject(createGroupData, url, projectId, firebaseServerKey);
    }

    public Object sendNotificationToGroup(String groupKey, Object data) {
        Map<String, Object> requestNotification = new HashMap<>();
        requestNotification.put("to", groupKey);
        requestNotification.put("data", data);
        return sendNotification(requestNotification);
    }

    public String getNotificationKey(String groupName) {
        var url = firebaseBaseUrl + pathNotification + "?notification_key_name=" + groupName;
        var response = getNotificationKey(url, projectId, firebaseServerKey);
        if (response == null) {
            return null;
        }
        var data = ConvertUtils.toObject(response, Map.class);
        return data.get("notification_key").toString();
    }

    public Object sendNotificationToListDevice(Set<String> registrationId, Object data) {
        Map<String, Object> requestNotification = new HashMap<>();
        requestNotification.put("registration_ids", registrationId);

        requestNotification.put("data", data);
        return sendNotification(requestNotification);
    }

    public Object sendNotificationToListDevice(Set<String> registrationId, Object notification, Object data) {
        Map<String, Object> requestNotification = new HashMap<>();
        requestNotification.put("registration_ids", registrationId);
        requestNotification.put("notification", notification);
        requestNotification.put("data", data);
        return sendNotification(requestNotification);
    }

    public Object sendAll(Object data) {
        return sendNotification(data, firebaseServerKey);
    }

    public Object sendNotification(Object data) {
        return sendNotification(data, firebaseServerKey);
    }

    public Object sendNotification(Object data, String serverKey) {
        var url = firebaseBaseUrl + pathSend;
        return postObject(data, url, null, serverKey);
    }

    public Object postObject(Object data, String url, String projectId, String serverKey) {
        log.info("(postObject) url: {}, request: {}",
                url, ConvertUtils.toStringJson(data));

        try {
            var header = new HttpHeaders();
            header.set(HttpHeaders.AUTHORIZATION, "key=" + serverKey);
            header.set(HttpHeaders.CONTENT_TYPE, "application/json");
            header.set("project_id", projectId);
            HttpEntity<Object> entity = new HttpEntity<>(data, header);
            var response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    Object.class
            );
            log.info("(postObject) response: {}", response);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }
        } catch (Exception ex) {
            log.error("(postObject) ERROR: {}", getFullStackTrace(ex));
        }
        return null;
    }

    public Object getObject(String url, String serverKey) {
        log.info("(getObject) url: {}",
                url);
        try {
            var header = new HttpHeaders();
            header.set(HttpHeaders.AUTHORIZATION, "key=" + serverKey);
            header.set(HttpHeaders.CONTENT_TYPE, "application/json");
            HttpEntity<Object> entity = new HttpEntity<>(null, header);
            var response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    Object.class
            );
            log.info("(getObject) response: {}", response);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }
        } catch (Exception ex) {
            log.error("(getObject) ERROR: {}", getFullStackTrace(ex));
        }
        return null;
    }

    @Override
    public Object getNotificationKey(String url, String projectId, String serverKey) {
        log.info("(getNotificationKey) url: {}",
                url);
        try {
            var header = new HttpHeaders();
            header.set(HttpHeaders.AUTHORIZATION, "key=" + serverKey);
            header.set(HttpHeaders.CONTENT_TYPE, "application/json");
            header.set("project_id", projectId);
            HttpEntity<Object> entity = new HttpEntity<>(null, header);
            var response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    Object.class
            );
            log.info("(getNotificationKey) response: {}", response);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }
        } catch (Exception ex) {
            log.warn("(getNotificationKey) ERROR: {}", ex.getMessage());
        }
        log.info("(getNotificationKey) notification key not found");
        return null;
    }
}
