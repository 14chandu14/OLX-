package com.zensar.olx.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olx.bean.AdvertisementStatus;

public interface AdvertisementStatusDAO extends JpaRepository<AdvertisementStatus, Integer> {

}
