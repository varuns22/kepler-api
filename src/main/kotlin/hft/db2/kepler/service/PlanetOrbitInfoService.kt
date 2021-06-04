package hft.db2.kepler.service

import hft.db2.kepler.common.Constants
import hft.db2.kepler.model.PlanetOrbitInfo
import hft.db2.kepler.repositories.PlanetOrbitInfoRepository
import hft.db2.kepler.repositories.PlanetPlanetRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PlanetOrbitInfoService(
    val planetOrbitInfoRepository: PlanetOrbitInfoRepository,
    val planetPlanetRepository: PlanetPlanetRepository
) {

    fun getAllPlanetOrbit(page: Int?, maxResults: Int?): List<PlanetOrbitInfo> {
        val pageRequest = PageRequest.of(page ?: Constants.DEFAULT_PAGE, maxResults ?: Constants.DEFAULT_MAX_RESULTS)
        return planetOrbitInfoRepository.findAll(pageRequest).content
    }

    fun getPlanetOrbitByPlanetId(pId: Int): PlanetOrbitInfo {
        return planetOrbitInfoRepository.findByPlanetId(pId)
    }

    @Transactional
    fun create(body: PlanetOrbitInfo, pId: Int): PlanetOrbitInfo {
        val planet = planetPlanetRepository.findById(pId).get()
        val sun = planet.sun
        return planetOrbitInfoRepository.save(
            body.copy(
                planet = planet,
                sun = sun
            )
        )
    }

    @Transactional
    fun update(body: PlanetOrbitInfo, pId: Int): PlanetOrbitInfo {
        val planetOrbit = planetOrbitInfoRepository.findByPlanetId(pId)
        val planet = planetOrbit.planet
        val sun = planet?.sun
        return planetOrbitInfoRepository.save(
            planetOrbit.copy(
                planet = planet,
                sun = sun,
                plOrbper = body.plOrbper,
                plOrbperlim = body.plOrbperlim,
                plOrbsmax = body.plOrbsmax,
                plOrbsmaxlim = body.plOrbsmaxlim,
                plOrbeccen = body.plOrbeccen,
                plOrbeccenlim = body.plOrbeccenlim,
                plOrbincl = body.plOrbincl,
                plOrbincllim = body.plOrbincllim
            )
        )
    }

    @Transactional
    fun remove(poId: Int) {
        planetOrbitInfoRepository.deleteById(poId)
    }


}
