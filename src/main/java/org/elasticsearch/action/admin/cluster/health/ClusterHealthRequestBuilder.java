/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.action.admin.cluster.health;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.support.master.MasterNodeOperationRequestBuilder;
import org.elasticsearch.client.ClusterAdminClient;
import org.elasticsearch.client.internal.InternalClusterAdminClient;
import org.elasticsearch.common.unit.TimeValue;

/**
 *
 */
public class ClusterHealthRequestBuilder extends MasterNodeOperationRequestBuilder<ClusterHealthRequest, ClusterHealthResponse, ClusterHealthRequestBuilder> {

    public ClusterHealthRequestBuilder(ClusterAdminClient clusterClient) {
        super((InternalClusterAdminClient) clusterClient, new ClusterHealthRequest());
    }

    public ClusterHealthRequestBuilder setIndices(String... indices) {
        request.setIndices(indices);
        return this;
    }

    public ClusterHealthRequestBuilder setTimeout(TimeValue timeout) {
        request.setTimeout(timeout);
        return this;
    }

    public ClusterHealthRequestBuilder setTimeout(String timeout) {
        request.setTimeout(timeout);
        return this;
    }

    public ClusterHealthRequestBuilder setWaitForStatus(ClusterHealthStatus waitForStatus) {
        request.setWaitForStatus(waitForStatus);
        return this;
    }

    public ClusterHealthRequestBuilder setWaitForGreenStatus() {
        request.setWaitForGreenStatus();
        return this;
    }

    public ClusterHealthRequestBuilder setWaitForYellowStatus() {
        request.setWaitForYellowStatus();
        return this;
    }

    public ClusterHealthRequestBuilder setWaitForRelocatingShards(int waitForRelocatingShards) {
        request.setWaitForRelocatingShards(waitForRelocatingShards);
        return this;
    }

    public ClusterHealthRequestBuilder setWaitForActiveShards(int waitForActiveShards) {
        request.setWaitForActiveShards(waitForActiveShards);
        return this;
    }

    /**
     * Waits for N number of nodes. Use "12" for exact mapping, ">12" and "<12" for range.
     */
    public ClusterHealthRequestBuilder setWaitForNodes(String waitForNodes) {
        request.setWaitForNodes(waitForNodes);
        return this;
    }

    @Override
    protected void doExecute(ActionListener<ClusterHealthResponse> listener) {
        ((ClusterAdminClient) client).health(request, listener);
    }
}
