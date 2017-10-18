package train.ridequery.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import train.ridequery.vo.NonStopVo;

import java.util.List;

/**
 * Created by zhao on 2017/10/18.
 */
@Mapper
public interface RideMapper {

    @Select("")
    List<NonStopVo> findNonStopVoByLeaveAndArrive(String leavaName, String arriveName);

}
