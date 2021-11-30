package QuanLyCacLoaiTramDo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "OBJECT_TYPE")
public class Device {

    @Column(name = "object_TYPE_ID")
    private long object_TYPE_ID;

    @Id
    @Column(name = "object_TYPE")
    private String object_TYPE;

    @Column(name = "object_TYPE_SHORTNAME")
    private String object_TYPE_SHORTNAME;
    private String is_AUTO;

}
