package vn.edupiamath.googlesheetcore.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Set;

public class GoogleSheetService {
    private static final Logger log = LoggerFactory.getLogger(GoogleSheetService.class);
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final Set<String> SCOPES = SheetsScopes.all();
    private final String applicationName;
    private final GoogleAuthenticationService authService;
//    private final RateLimiter rateLimiter;

    public GoogleSheetService(
            String applicationName,
            GoogleAuthenticationService authService
//            RateLimiter rateLimiter
    ) {
        this.applicationName = applicationName;
        this.authService = authService;
//        this.rateLimiter = rateLimiter;
    }

    public void clear(String spreadsheetId, String range) throws Exception {
        log.info("(clear)spreadsheetId: {}, range: {}", spreadsheetId, range);
        ClearValuesRequest body = new ClearValuesRequest();
        ClearValuesResponse result = (ClearValuesResponse)this.getSheets().spreadsheets().values().clear(spreadsheetId, range, body).execute();
        log.info("(clear)spreadsheetId: {}, range: {}, result: {}", spreadsheetId, range, result);
    }

    public List<List<Object>> read(String spreadsheetId, String range) throws Exception {
        log.info("(read)spreadsheetId: {}, range: {}", spreadsheetId, range);
        ValueRange response = (ValueRange)this.getSheets().spreadsheets().values().get(spreadsheetId, range).execute();
        return response.getValues();
    }

    public void update(String spreadsheetId, BatchUpdateSpreadsheetRequest request) throws Exception {
        log.info("(update)spreadsheetId: {}", spreadsheetId);
        this.getSheets().spreadsheets().batchUpdate(spreadsheetId, request).execute();
    }

    public void update(String spreadsheetId, String range, List<List<Object>> values) throws Exception {
        log.info("(write)spreadsheetId: {}, range: {}", spreadsheetId, range);
        ValueRange body = (new ValueRange()).setValues(values);
        UpdateValuesResponse result = (UpdateValuesResponse)this.getSheets().spreadsheets().values().update(spreadsheetId, range, body).setValueInputOption(InputOption.RAW.name()).execute();
        log.info("(write)spreadsheetId: {}, range: {}, result: {}", spreadsheetId, range, result);
    }

    public void write(String spreadsheetId, String range, List<List<Object>> values) throws Exception {
        log.info("(write)spreadsheetId: {}, range: {}", spreadsheetId, range);
        ValueRange body = (new ValueRange()).setValues(values);
        AppendValuesResponse result = (AppendValuesResponse)this.getSheets().spreadsheets().values().append(spreadsheetId, range, body).setValueInputOption(InputOption.RAW.name()).execute();
        log.info("(write)spreadsheetId: {}, range: {}, result: {}", spreadsheetId, range, result);
    }

    private Sheets getSheets() throws IOException, GeneralSecurityException {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return (new Sheets.Builder(httpTransport, JSON_FACTORY, this.authService.getCredentials(httpTransport, SCOPES))).setApplicationName(this.applicationName).build();
    }
}
