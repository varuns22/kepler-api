package hft.db2.kepler.repositories

import hft.db2.kepler.model.PlanetPlanetModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlanetPlanetRepository : JpaRepository<PlanetPlanetModel, Int> {
}
