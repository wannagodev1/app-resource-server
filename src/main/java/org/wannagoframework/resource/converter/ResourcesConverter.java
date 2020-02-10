/*
 * This file is part of the WannaGo distribution (https://github.com/wannago).
 * Copyright (c) [2019] - [2020].
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */


package org.wannagoframework.resource.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.wannagoframework.commons.utils.OrikaBeanMapper;
import org.wannagoframework.dto.utils.StoredFile;

/**
 * @author WannaGo Dev1.
 * @version 1.0
 * @since 2019-06-05
 */
@Component
public class ResourcesConverter {

  private final OrikaBeanMapper orikaBeanMapper;

  public ResourcesConverter(OrikaBeanMapper orikaBeanMapper) {
    this.orikaBeanMapper = orikaBeanMapper;
  }

  @Bean
  public void resourcesConverters() {
    orikaBeanMapper.addMapper(StoredFile.class,
        org.wannagoframework.resource.domain.StoredFile.class);
    orikaBeanMapper.addMapper(org.wannagoframework.resource.domain.StoredFile.class, StoredFile.class);
  }
}