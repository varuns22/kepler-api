package hft.db2.kepler.repositories

import hft.db2.kepler.model.PlanetSizeInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface PlanetSizeInfoRepository : JpaRepository<PlanetSizeInfo, Int> {

    @Query("SELECT ps FROM PlanetSizeInfo ps WHERE ps.planet.planetId=?1")
    fun findPlanetSizeInfoByPlanetId(pId: Int): PlanetSizeInfo
}
