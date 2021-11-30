package QuanLyCacLoaiTramDo.repository;

import QuanLyCacLoaiTramDo.entity.LogsAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsActionRepository extends JpaRepository<LogsAction, Long> {
    @Query(value = "SELECT MAX(ins_PARAM_ID) FROM LOGS_ACTION_DETAIL", nativeQuery = true)
    Long getMaxIDCurrent();
}
