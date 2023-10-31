package vn.edupiamath.googlesheetcore.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Set;

public class GoogleAuthenticationService {
    private static final Logger log = LoggerFactory.getLogger(GoogleAuthenticationService.class);
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private final String credentialFolder;
    private final String credentialJsonPath;

    public GoogleAuthenticationService(String credentialFolder, String credentialJsonPath) {
        this.credentialFolder = credentialFolder;
        this.credentialJsonPath = credentialJsonPath;
    }

    public Credential getCredentials(NetHttpTransport httpTransport, Set<String> scopes) throws IOException {
        InputStream in = new FileInputStream(this.credentialJsonPath);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        GoogleAuthorizationCodeFlow flow = (new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, scopes))
                .setDataStoreFactory(new FileDataStoreFactory(new File(this.credentialFolder)))
                .setAccessType("offline").build();
        return (new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())).authorize("user");
    }
}
