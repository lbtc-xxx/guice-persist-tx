package app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MyEntity implements Serializable {

    @Id
    private Integer id;

    protected MyEntity() {
    }

    public MyEntity(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                '}';
    }
}
