package hft.db2.kepler.service

import hft.db2.kepler.common.Constants
import hft.db2.kepler.model.PlanetSizeInfo
import hft.db2.kepler.repositories.PlanetPlanetRepository
import hft.db2.kepler.repositories.PlanetSizeInfoRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PlanetSizeInfoService(
    val planetSizeInfoRepository: PlanetSizeInfoRepository,
    val planetPlanetRepository: PlanetPlanetRepository
) {

    fun getAllPlanetSizeInfo(page: Int?, maxResults: Int?): List<PlanetSizeInfo> {
        val pageRequest = PageRequest.of(page ?: Constants.DEFAULT_PAGE, maxResults ?: Constants.DEFAULT_MAX_RESULTS)
        return planetSizeInfoRepository.findAll(pageRequest).content
    }

    fun findByPlanetId(pId: Int): PlanetSizeInfo {
        return planetSizeInfoRepository.findPlanetSizeInfoByPlanetId(pId)
    }

    @Transactional
    fun create(body: PlanetSizeInfo, pId: Int): PlanetSizeInfo {
        val planet = planetPlanetRepository.findById(pId).get()
        return planetSizeInfoRepository.save(body.copy(planet = planet))
    }

    @Transactional
    fun update(body: PlanetSizeInfo, pId: Int): PlanetSizeInfo {
        val original = findByPlanetId(pId)
        return planetSizeInfoRepository.save(
            original.copy(
                plBmassj = body.plBmassj,
                plBmassjlim = body.plBmassjlim,
                plBmassprov = body.plBmassprov,
                plRadj = body.plRadj,
                plRadjlim = body.plRadjlim,
                plDens = body.plDens,
                plDenslim = body.plDenslim
            )
        )
    }

    @Transactional
    fun remove(psId: Int) {
        planetSizeInfoRepository.deleteById(psId)
    }
}
