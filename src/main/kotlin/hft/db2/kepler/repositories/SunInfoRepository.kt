package hft.db2.kepler.repositories

import hft.db2.kepler.model.SunInfoModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SunInfoRepository : JpaRepository<SunInfoModel, Int> {

    fun findBySunName(sunName: String): SunInfoModel?
}
