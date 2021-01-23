package com.incidences.incidencesapp.models;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class IncidencesModel {


    public ArrayList<IncidencesEntity> getAllSummarize() {
        Realm realm = Realm.getDefaultInstance();
        ArrayList<IncidencesEntity> list = new ArrayList<>();
        ArrayList<IncidencesEntity> filtered = new ArrayList<>();
        //id, imagen y 2 campos de texto xd por si se me olvida
        RealmResults<IncidencesEntity> result = realm.where(IncidencesEntity.class).findAll();
        list.addAll(realm.copyFromRealm(result));

        for (IncidencesEntity i : list) {

        }

        realm.close();
        return filtered;
    }

    public boolean insert(IncidencesEntity incidence) {
        boolean flag;
        incidence.setId(UUID.randomUUID().toString());
        System.out.println(incidence);
        try {
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            realm.copyToRealm(incidence);
            realm.commitTransaction();
            realm.close();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
