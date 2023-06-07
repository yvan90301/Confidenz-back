package com.isj.confidenz.repositories;
import com.isj.confidenz.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {
}
