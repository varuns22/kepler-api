package hft.db2.kepler.repositories

import hft.db2.kepler.model.PlanetOrbitInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface PlanetOrbitInfoRepository : JpaRepository<PlanetOrbitInfo, Int> {

    @Query("SELECT po FROM PlanetOrbitInfo po WHERE po.planet.planetId=?1")
    fun findByPlanetId(pId: Int): PlanetOrbitInfo
}
