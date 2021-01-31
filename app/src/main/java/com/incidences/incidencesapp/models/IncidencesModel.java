package com.incidences.incidencesapp.models;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class IncidencesModel {


    public ArrayList<IncidencesEntity> getAllSummarize() {
        Realm realm = Realm.getDefaultInstance();
        ArrayList<IncidencesEntity> list = new ArrayList<>();
        ArrayList<IncidencesEntity> filtered = new ArrayList<>();
        RealmResults<IncidencesEntity> result = realm.where(IncidencesEntity.class).findAll();
        list.addAll(realm.copyFromRealm(result));
        realm.close();

        for (IncidencesEntity i : list) {
            IncidencesEntity incidencesEntity = new IncidencesEntity();
            incidencesEntity.setName(i.getName());
            incidencesEntity.setImage(i.getImage());
            incidencesEntity.setDate(i.getDate());
            incidencesEntity.setId(i.getId());
            filtered.add(incidencesEntity);
        }

        return filtered;
    }

    public IncidencesEntity getItemById(String id) {
        Realm realm = Realm.getDefaultInstance();
        IncidencesEntity result = realm.copyFromRealm(Objects.requireNonNull(realm.where(IncidencesEntity.class).equalTo("id", id).findFirst()));
        realm.close();
        return result;
    }


    public ArrayList<IncidencesEntity> getItemsByName(String name) {
        Realm realm = Realm.getDefaultInstance();
        ArrayList<IncidencesEntity> list = new ArrayList<>();
        RealmResults<IncidencesEntity> result = realm.where(IncidencesEntity.class).contains("name", name).findAll();
        list.addAll(realm.copyFromRealm(result));
        realm.close();
        return list;
    }

    public ArrayList<IncidencesEntity> getItemsBySeverity(String severity) {
        Realm realm = Realm.getDefaultInstance();
        ArrayList<IncidencesEntity> list = new ArrayList<>();
        RealmResults<IncidencesEntity> result = realm.where(IncidencesEntity.class).equalTo("severity", severity).findAll();
        list.addAll(realm.copyFromRealm(result));
        realm.close();
        return list;
    }

    public ArrayList<IncidencesEntity> getItemsByDate(String date) {
        Realm realm = Realm.getDefaultInstance();
        ArrayList<IncidencesEntity> list = new ArrayList<>();
        RealmResults<IncidencesEntity> result = realm.where(IncidencesEntity.class).equalTo("date", date).findAll();
        list.addAll(realm.copyFromRealm(result));
        realm.close();
        return list;
    }

    public boolean insert(IncidencesEntity incidence) {
        boolean flag;
        incidence.setId(UUID.randomUUID().toString());
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealm(incidence);
            realm.commitTransaction();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        realm.close();

        return flag;
    }

    public boolean delete(IncidencesEntity incidence) {
        boolean flag;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            IncidencesEntity result = realm.where(IncidencesEntity.class).equalTo("id", incidence.getId()).findFirst();
            result.deleteFromRealm();
            realm.commitTransaction();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        realm.close();

        return flag;
    }

    public boolean update(IncidencesEntity incidence) {
        boolean flag;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            IncidencesEntity result = realm.where(IncidencesEntity.class).equalTo("id", incidence.getId()).findFirst();
            IncidencesEntity result2 = realm.copyFromRealm(result);
            result2.setSeverity(incidence.getSeverity());
            result2.setPhone(incidence.getPhone());
            result2.setDate(incidence.getDate());
            result2.setSite(incidence.getSite());
            result2.setDescription(incidence.getDescription());
            result2.setName(incidence.getName());
            result2.setImage(incidence.getImage());
            result2.setResolved(incidence.isResolved());
            realm.insertOrUpdate(result2);
            realm.commitTransaction();
            flag = true;
        } catch (Exception e) {
            flag = false;
            System.out.println(e);
        }
        realm.close();

        return flag;
    }

    public ArrayList<String> getSeverities() {
        Realm realm = Realm.getDefaultInstance();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<IncidencesEntity> e = new ArrayList<>();
        RealmResults<IncidencesEntity> result = realm.where(IncidencesEntity.class).distinct("severity").findAll();
        if (result != null && !result.isEmpty()) {
            e.addAll(realm.copyFromRealm(result));
            for (IncidencesEntity i : e) {
                if (i.getSeverity() != null) {
                    list.add(i.getSeverity());
                }
            }
        }
        realm.close();
        return list;
    }

    public ArrayList<IncidencesEntity> getItemsByAllCriterias(String severity, String date, String title) {
        Realm realm = Realm.getDefaultInstance();
        ArrayList<IncidencesEntity> list = new ArrayList<>();
        RealmResults<IncidencesEntity> result = realm.where(IncidencesEntity.class).contains("name", title).and().equalTo("date", date).and().equalTo("severity", severity).findAll();
        list.addAll(realm.copyFromRealm(result));
        realm.close();
        return list;
    }
}
