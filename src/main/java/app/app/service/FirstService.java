package app.app.service;

import app.entity.MyEntity;
import com.google.inject.persist.Transactional;

public interface FirstService {
    void firstSave(MyEntity myEntity);
}
