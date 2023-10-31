package vn.edupiamath.firebaseclient.services;

import java.util.List;
import java.util.Set;

public interface FirebaseClient {

    Object createGroupNotification(String groupName, List<String> registrationIds);

    Object addDeviceToGroup(String groupName, String notificationKey, List<String> registrationIds);

    Object removeDeviceFromGroup(String groupName, String notificationKey, List<String> registrationIds);

    Object sendNotificationToGroup(String groupKey, Object data);

    String getNotificationKey(String groupName);

    Object sendNotificationToListDevice(Set<String> registrationId, Object data);

    Object sendNotificationToListDevice(Set<String> registrationId, Object notification, Object data);

    Object sendAll(Object data);

    Object sendNotification(Object data);

    Object sendNotification(Object data, String serverKey);

    Object postObject(Object data, String url, String projectId, String serverKey);

    Object getObject(String url, String serverKey);

    Object getNotificationKey(String url, String projectId, String serverKey);
}
