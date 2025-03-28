/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Transcription extends Resource {

    private static final long serialVersionUID = 149103878272565L;

    public static TranscriptionCreator creator(final String pathCallSid) {
        return new TranscriptionCreator(pathCallSid);
    }

    public static TranscriptionCreator creator(
        final String pathAccountSid,
        final String pathCallSid
    ) {
        return new TranscriptionCreator(pathAccountSid, pathCallSid);
    }

    public static TranscriptionUpdater updater(
        final String pathCallSid,
        final String pathSid,
        final Transcription.UpdateStatus status
    ) {
        return new TranscriptionUpdater(pathCallSid, pathSid, status);
    }

    public static TranscriptionUpdater updater(
        final String pathAccountSid,
        final String pathCallSid,
        final String pathSid,
        final Transcription.UpdateStatus status
    ) {
        return new TranscriptionUpdater(
            pathAccountSid,
            pathCallSid,
            pathSid,
            status
        );
    }

    /**
     * Converts a JSON String into a Transcription object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Transcription object represented by the provided JSON
     */
    public static Transcription fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Transcription.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Transcription object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Transcription object represented by the provided JSON
     */
    public static Transcription fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Transcription.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String callSid;
    private final String name;
    private final Transcription.Status status;
    private final ZonedDateTime dateUpdated;
    private final String uri;

    @JsonCreator
    private Transcription(
        @JsonProperty("sid") final String sid,
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("call_sid") final String callSid,
        @JsonProperty("name") final String name,
        @JsonProperty("status") final Transcription.Status status,
        @JsonProperty("date_updated") final String dateUpdated,
        @JsonProperty("uri") final String uri
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.callSid = callSid;
        this.name = name;
        this.status = status;
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.uri = uri;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getCallSid() {
        return this.callSid;
    }

    public final String getName() {
        return this.name;
    }

    public final Transcription.Status getStatus() {
        return this.status;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Transcription other = (Transcription) o;

        return (
            Objects.equals(sid, other.sid) &&
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(callSid, other.callSid) &&
            Objects.equals(name, other.name) &&
            Objects.equals(status, other.status) &&
            Objects.equals(dateUpdated, other.dateUpdated) &&
            Objects.equals(uri, other.uri)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            sid,
            accountSid,
            callSid,
            name,
            status,
            dateUpdated,
            uri
        );
    }

    public enum Track {
        INBOUND_TRACK("inbound_track"),
        OUTBOUND_TRACK("outbound_track"),
        BOTH_TRACKS("both_tracks");

        private final String value;

        private Track(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Track forValue(final String value) {
            return Promoter.enumFromString(value, Track.values());
        }
    }

    public enum UpdateStatus {
        STOPPED("stopped");

        private final String value;

        private UpdateStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static UpdateStatus forValue(final String value) {
            return Promoter.enumFromString(value, UpdateStatus.values());
        }
    }

    public enum Status {
        IN_PROGRESS("in-progress"),
        STOPPED("stopped");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }
}
