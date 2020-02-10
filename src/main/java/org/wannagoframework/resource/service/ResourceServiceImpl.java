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


package org.wannagoframework.resource.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wannagoframework.commons.utils.HasLogger;
import org.wannagoframework.resource.domain.StoredFile;
import org.wannagoframework.resource.exception.EntityNotFoundException;
import org.wannagoframework.resource.repository.StoredFileRepository;

/**
 * @author WannaGo Dev1.
 * @version 1.0
 * @since 2019-05-15
 */
@Service
@Transactional(readOnly = true)
public class ResourceServiceImpl implements ResourceService, HasLogger {

  private final StoredFileRepository storedFileRepository;

  public ResourceServiceImpl(
      StoredFileRepository storedFileRepository) {
    this.storedFileRepository = storedFileRepository;
  }

  @Override
  @Transactional
  public void delete(String id) {
    if (id == null) {
      throw new EntityNotFoundException();
    }
    StoredFile entity = storedFileRepository.findById(id).orElse(null);
    if (entity == null) {
      throw new EntityNotFoundException();
    }
    storedFileRepository.delete(entity);
  }

  @Override
  public StoredFile getById(String id) {
    return storedFileRepository.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public StoredFile save(StoredFile entity) {
    if (entity == null) {
      throw new EntityNotFoundException();
    }
    return storedFileRepository.save(entity);
  }
}
