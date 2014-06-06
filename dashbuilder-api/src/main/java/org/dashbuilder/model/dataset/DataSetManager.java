/**
 * Copyright (C) 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dashbuilder.model.dataset;

import org.jboss.errai.bus.server.annotations.Remote;

/**
 * Main interface for handling data sets.
 */
@Remote
public interface DataSetManager {

    /**
     * Create a brand new data set instance.
     * @param uuid The UUID to assign to the new data set.
     */
    DataSet createDataSet(String uuid);

    /**
     * Retrieve (load if required) a data set.
     * @param uuid The UUID of the data set.
     */
    DataSet getDataSet(String uuid) throws Exception;

    /**
     * Fetch the metadata instance for the specified data set.
     * @param uuid The UUID of the data set.
     */
    DataSetMetadata getDataSetMetadata(String uuid) throws Exception;

    /**
     * Registers the specified data set instance.
     */
    void registerDataSet(DataSet dataSet);

    /**
     * Load a data set and apply several operations (filter, sort, group, ...) on top of it.
     */
    DataSet lookupDataSet(DataSetLookup lookup) throws Exception;

    /**
     * Same as lookupDataSet but only retrieves a preview of the resulting data set.
     * @return A DataSetMetadata instance containing general information about the data set.
     */
    DataSetMetadata lookupDataSetMetadata(DataSetLookup lookup) throws Exception;
}
