package QuanLyCacLoaiTramDo.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LOGS_ACTION_DETAIL")

public class LogsAction {

    @Id
    @Column(name = "ins_PARAM_ID")
    private long ins_PARAM_ID;

    @Column(name = "menu_NAME")
    private String menu_NAME;

    @Column(name = "action")
    private String action;

    @Column(name = "user_ACT")
    private String user_ACT;

    @Column(name = "date_ACT")
    private Timestamp date_ACT;

    @Column(name = "table_NAME")
    private String table_NAME;
}

