package hft.db2.kepler.service

import hft.db2.kepler.common.Constants
import hft.db2.kepler.model.PlanetPlanetModel
import hft.db2.kepler.repositories.PlanetPlanetRepository
import hft.db2.kepler.repositories.SunInfoRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PlanetPlanetService(
    val planetPlanetRepository: PlanetPlanetRepository,
    val sunInfoRepository: SunInfoRepository
) {

    fun getAllPlanetPlanet(page: Int?, maxResults: Int?): List<PlanetPlanetModel> {
        val pageRequest = PageRequest.of(page ?: Constants.DEFAULT_PAGE, maxResults ?: Constants.DEFAULT_MAX_RESULTS)
        return planetPlanetRepository.findAll(pageRequest).content
    }

    @Transactional
    fun create(body: PlanetPlanetModel): PlanetPlanetModel {
        val sun = sunInfoRepository.findBySunName(body.sun!!.sunName)
        return planetPlanetRepository.save(body.copy(sun = sun))
    }

    @Transactional
    fun update(body: PlanetPlanetModel, pId: Int): PlanetPlanetModel {
        val planetToUpdate = planetPlanetRepository.findById(pId).get()
        val sun = sunInfoRepository.findBySunName(body.sun!!.sunName)
        return planetPlanetRepository.save(
            planetToUpdate.copy(
                sun = sun,
                plLetter = body.plLetter,
                plDiscmethod = body.plDiscmethod,
                plPnum = body.plPnum,
                plTtvflag = body.plTtvflag,
                plKepflag = body.plKepflag,
                plK2flag = body.plK2flag,
                plNnotes = body.plNnotes,
                raStr = body.raStr,
                ra = body.ra,
                declinStr = body.declinStr,
                declin = body.declin
            )
        )
    }

    @Transactional
    fun remove(pId: Int) {
        planetPlanetRepository.deleteById(pId)
    }

}
