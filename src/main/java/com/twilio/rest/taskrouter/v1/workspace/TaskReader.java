/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.constant.EnumConstants;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.util.List;

public class TaskReader extends Reader<Task> {

    private String pathWorkspaceSid;
    private Integer priority;
    private List<String> assignmentStatus;
    private String workflowSid;
    private String workflowName;
    private String taskQueueSid;
    private String taskQueueName;
    private String evaluateTaskAttributes;
    private String routingTarget;
    private String ordering;
    private Boolean hasAddons;
    private Long pageSize;

    public TaskReader(final String pathWorkspaceSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    public TaskReader setPriority(final Integer priority) {
        this.priority = priority;
        return this;
    }

    public TaskReader setAssignmentStatus(final List<String> assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
        return this;
    }

    public TaskReader setAssignmentStatus(final String assignmentStatus) {
        return setAssignmentStatus(Promoter.listOfOne(assignmentStatus));
    }

    public TaskReader setWorkflowSid(final String workflowSid) {
        this.workflowSid = workflowSid;
        return this;
    }

    public TaskReader setWorkflowName(final String workflowName) {
        this.workflowName = workflowName;
        return this;
    }

    public TaskReader setTaskQueueSid(final String taskQueueSid) {
        this.taskQueueSid = taskQueueSid;
        return this;
    }

    public TaskReader setTaskQueueName(final String taskQueueName) {
        this.taskQueueName = taskQueueName;
        return this;
    }

    public TaskReader setEvaluateTaskAttributes(
        final String evaluateTaskAttributes
    ) {
        this.evaluateTaskAttributes = evaluateTaskAttributes;
        return this;
    }

    public TaskReader setRoutingTarget(final String routingTarget) {
        this.routingTarget = routingTarget;
        return this;
    }

    public TaskReader setOrdering(final String ordering) {
        this.ordering = ordering;
        return this;
    }

    public TaskReader setHasAddons(final Boolean hasAddons) {
        this.hasAddons = hasAddons;
        return this;
    }

    public TaskReader setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Task> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Task> firstPage(final TwilioRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/Tasks";
        path =
            path.replace(
                "{" + "WorkspaceSid" + "}",
                this.pathWorkspaceSid.toString()
            );

        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            path
        );

        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        return pageForRequest(client, request);
    }

    private Page<Task> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "Task read failed: Unable to connect to server"
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

        return Page.fromJson(
            "tasks",
            response.getContent(),
            Task.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Task> previousPage(
        final Page<Task> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.TASKROUTER.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Task> nextPage(
        final Page<Task> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.TASKROUTER.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Task> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (priority != null) {
            request.addQueryParam("Priority", priority.toString());
        }
        if (assignmentStatus != null) {
            for (String prop : assignmentStatus) {
                request.addQueryParam("AssignmentStatus", prop);
            }
        }
        if (workflowSid != null) {
            request.addQueryParam("WorkflowSid", workflowSid);
        }
        if (workflowName != null) {
            request.addQueryParam("WorkflowName", workflowName);
        }
        if (taskQueueSid != null) {
            request.addQueryParam("TaskQueueSid", taskQueueSid);
        }
        if (taskQueueName != null) {
            request.addQueryParam("TaskQueueName", taskQueueName);
        }
        if (evaluateTaskAttributes != null) {
            request.addQueryParam(
                "EvaluateTaskAttributes",
                evaluateTaskAttributes
            );
        }
        if (routingTarget != null) {
            request.addQueryParam("RoutingTarget", routingTarget);
        }
        if (ordering != null) {
            request.addQueryParam("Ordering", ordering);
        }
        if (hasAddons != null) {
            request.addQueryParam("HasAddons", hasAddons.toString());
        }
        if (pageSize != null) {
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
