/*
 *
 *  * Copyright 2016 http://www.hswebframework.org
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.hswebframework.web.controller;

import org.hswebframework.web.commons.beans.Bean;
import org.hswebframework.web.commons.beans.GenericBean;
import org.hswebframework.web.commons.beans.param.QueryParamBean;
import org.hswebframework.web.controller.message.ResponseMessage;
import org.hswebframework.web.service.CrudService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static org.hswebframework.web.controller.message.ResponseMessage.ok;

/**
 * TODO 完成注释
 *
 * @author zhouhao
 */
public interface GenericBeanController<B extends GenericBean<PK>, PK, Q extends Bean>
        extends CrudController<B, PK, Q> {

    CrudService<B, PK, Q> getService();

    @Override
    default ResponseMessage updateByPrimaryKey(@PathVariable PK id, @RequestBody B data) {
        data.setId(id);
        return ok(getService().updateByPk(data));
    }
}
