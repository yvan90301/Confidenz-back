package com.isj.confidenz.services;

import com.isj.confidenz.Iservices.INotification;
import com.isj.confidenz.dtos.NotificationDto;
import com.isj.confidenz.models.Employe;
import com.isj.confidenz.models.Notification;
import com.isj.confidenz.repositories.EmployeRepository;
import com.isj.confidenz.repositories.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class NotificationService implements INotification {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public void ajouterNotif(NotificationDto notificationDto) {

        List<Employe> employes = employeRepository.findByEntreprise(notificationDto.getId_entreprise());

        for (Employe employe: employes){
            Notification notification = new Notification();

            notification.setContenu(notificationDto.getContenu());
            notification.setCreatedate(notificationDto.getCreatedate());
            notification.setId_employe(employe);
            notification.setId_entreprise(notificationDto.getId_entreprise());
            notification.setVue(notificationDto.getVue());
            notificationRepository.save(notification);
        }
    }
}
