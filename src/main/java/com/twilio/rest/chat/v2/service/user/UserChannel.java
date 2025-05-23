/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Chat
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.chat.v2.service.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Map;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class UserChannel extends Resource {

    private static final long serialVersionUID = 104594062960806L;

    public static UserChannelDeleter deleter(
        final String pathServiceSid,
        final String pathUserSid,
        final String pathChannelSid
    ) {
        return new UserChannelDeleter(
            pathServiceSid,
            pathUserSid,
            pathChannelSid
        );
    }

    public static UserChannelFetcher fetcher(
        final String pathServiceSid,
        final String pathUserSid,
        final String pathChannelSid
    ) {
        return new UserChannelFetcher(
            pathServiceSid,
            pathUserSid,
            pathChannelSid
        );
    }

    public static UserChannelReader reader(
        final String pathServiceSid,
        final String pathUserSid
    ) {
        return new UserChannelReader(pathServiceSid, pathUserSid);
    }

    public static UserChannelUpdater updater(
        final String pathServiceSid,
        final String pathUserSid,
        final String pathChannelSid
    ) {
        return new UserChannelUpdater(
            pathServiceSid,
            pathUserSid,
            pathChannelSid
        );
    }

    /**
     * Converts a JSON String into a UserChannel object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return UserChannel object represented by the provided JSON
     */
    public static UserChannel fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, UserChannel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a UserChannel object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return UserChannel object represented by the provided JSON
     */
    public static UserChannel fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, UserChannel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String serviceSid;
    private final String channelSid;
    private final String userSid;
    private final String memberSid;
    private final UserChannel.ChannelStatus status;
    private final Integer lastConsumedMessageIndex;
    private final Integer unreadMessagesCount;
    private final Map<String, String> links;
    private final URI url;
    private final UserChannel.NotificationLevel notificationLevel;

    @JsonCreator
    private UserChannel(
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("service_sid") final String serviceSid,
        @JsonProperty("channel_sid") final String channelSid,
        @JsonProperty("user_sid") final String userSid,
        @JsonProperty("member_sid") final String memberSid,
        @JsonProperty("status") final UserChannel.ChannelStatus status,
        @JsonProperty(
            "last_consumed_message_index"
        ) final Integer lastConsumedMessageIndex,
        @JsonProperty(
            "unread_messages_count"
        ) final Integer unreadMessagesCount,
        @JsonProperty("links") final Map<String, String> links,
        @JsonProperty("url") final URI url,
        @JsonProperty(
            "notification_level"
        ) final UserChannel.NotificationLevel notificationLevel
    ) {
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.channelSid = channelSid;
        this.userSid = userSid;
        this.memberSid = memberSid;
        this.status = status;
        this.lastConsumedMessageIndex = lastConsumedMessageIndex;
        this.unreadMessagesCount = unreadMessagesCount;
        this.links = links;
        this.url = url;
        this.notificationLevel = notificationLevel;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getServiceSid() {
        return this.serviceSid;
    }

    public final String getChannelSid() {
        return this.channelSid;
    }

    public final String getUserSid() {
        return this.userSid;
    }

    public final String getMemberSid() {
        return this.memberSid;
    }

    public final UserChannel.ChannelStatus getStatus() {
        return this.status;
    }

    public final Integer getLastConsumedMessageIndex() {
        return this.lastConsumedMessageIndex;
    }

    public final Integer getUnreadMessagesCount() {
        return this.unreadMessagesCount;
    }

    public final Map<String, String> getLinks() {
        return this.links;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final UserChannel.NotificationLevel getNotificationLevel() {
        return this.notificationLevel;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserChannel other = (UserChannel) o;

        return (
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(serviceSid, other.serviceSid) &&
            Objects.equals(channelSid, other.channelSid) &&
            Objects.equals(userSid, other.userSid) &&
            Objects.equals(memberSid, other.memberSid) &&
            Objects.equals(status, other.status) &&
            Objects.equals(
                lastConsumedMessageIndex,
                other.lastConsumedMessageIndex
            ) &&
            Objects.equals(unreadMessagesCount, other.unreadMessagesCount) &&
            Objects.equals(links, other.links) &&
            Objects.equals(url, other.url) &&
            Objects.equals(notificationLevel, other.notificationLevel)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountSid,
            serviceSid,
            channelSid,
            userSid,
            memberSid,
            status,
            lastConsumedMessageIndex,
            unreadMessagesCount,
            links,
            url,
            notificationLevel
        );
    }

    public enum WebhookEnabledType {
        TRUE("true"),
        FALSE("false");

        private final String value;

        private WebhookEnabledType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static WebhookEnabledType forValue(final String value) {
            return Promoter.enumFromString(value, WebhookEnabledType.values());
        }
    }

    public enum ChannelStatus {
        JOINED("joined"),
        INVITED("invited"),
        NOT_PARTICIPATING("not_participating");

        private final String value;

        private ChannelStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static ChannelStatus forValue(final String value) {
            return Promoter.enumFromString(value, ChannelStatus.values());
        }
    }

    public enum NotificationLevel {
        DEFAULT("default"),
        MUTED("muted");

        private final String value;

        private NotificationLevel(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static NotificationLevel forValue(final String value) {
            return Promoter.enumFromString(value, NotificationLevel.values());
        }
    }
}
