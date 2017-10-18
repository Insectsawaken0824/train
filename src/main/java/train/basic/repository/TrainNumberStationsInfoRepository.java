package train.basic.repository;

import org.springframework.data.repository.RepositoryDefinition;
import train.basic.domain.FormalTrainNumberStationsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhao on 2017/10/17.
 */
@RepositoryDefinition(domainClass = FormalTrainNumberStationsInfo.class, idClass = Integer.class)
public interface TrainNumberStationsInfoRepository {

    /**
     * 根据站名查询
     * @param name 车站名
     * @return 结果
     */
    List<FormalTrainNumberStationsInfo> findByStationsName(String name);
}
