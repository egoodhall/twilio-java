/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.messaging.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Creator;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ChannelsSenderCreator extends Creator<ChannelsSender> {

    private ChannelsSender.MessagingV2ChannelsSenderRequestsCreate messagingV2ChannelsSenderRequestsCreate;

    public ChannelsSenderCreator(
        final ChannelsSender.MessagingV2ChannelsSenderRequestsCreate messagingV2ChannelsSenderRequestsCreate
    ) {
        this.messagingV2ChannelsSenderRequestsCreate =
            messagingV2ChannelsSenderRequestsCreate;
    }

    public ChannelsSenderCreator setMessagingV2ChannelsSenderRequestsCreate(
        final ChannelsSender.MessagingV2ChannelsSenderRequestsCreate messagingV2ChannelsSenderRequestsCreate
    ) {
        this.messagingV2ChannelsSenderRequestsCreate =
            messagingV2ChannelsSenderRequestsCreate;
        return this;
    }

    @Override
    public ChannelsSender create(final TwilioRestClient client) {
        String path = "/v2/Channels/Senders";

        path =
            path.replace(
                "{" + "MessagingV2ChannelsSenderRequestsCreate" + "}",
                this.messagingV2ChannelsSenderRequestsCreate.toString()
            );

        Request request = new Request(
            HttpMethod.POST,
            Domains.MESSAGING.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.JSON);
        addPostParams(request, client);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "ChannelsSender creation failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException(
                    "Server Error, no content",
                    response.getStatusCode()
                );
            }
            throw new ApiException(restException);
        }

        return ChannelsSender.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request, TwilioRestClient client) {
        ObjectMapper objectMapper = client.getObjectMapper();
        if (messagingV2ChannelsSenderRequestsCreate != null) {
            request.setBody(
                ChannelsSender.toJson(
                    messagingV2ChannelsSenderRequestsCreate,
                    objectMapper
                )
            );
        }
    }
}
