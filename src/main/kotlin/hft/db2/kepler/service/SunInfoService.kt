package hft.db2.kepler.service

import hft.db2.kepler.common.Constants
import hft.db2.kepler.model.SunInfoModel
import hft.db2.kepler.repositories.SunInfoRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SunInfoService(
    val sunInfoRepository: SunInfoRepository
) {

    fun getAllSunInfo(page: Int?, maxResults: Int?): List<SunInfoModel> {
        val pageRequest = PageRequest.of(page ?: Constants.DEFAULT_PAGE, maxResults ?: Constants.DEFAULT_MAX_RESULTS)
        return sunInfoRepository.findAll(pageRequest).content
    }

    fun getAllSunNames(page: Int?, maxResults: Int?): List<String> {
        return getAllSunInfo(
            page ?: Constants.DEFAULT_PAGE,
            maxResults ?: Constants.DEFAULT_MAX_RESULTS
        ).map { it.sunName }
    }

    fun getAllPlanetsForSun(sunId: Int): SunInfoModel {
        return sunInfoRepository.findById(sunId).get()
    }

    @Transactional
    fun create(body: SunInfoModel): SunInfoModel {
        return sunInfoRepository.save(body)
    }

    @Transactional
    fun update(body: SunInfoModel, sunId: Int): SunInfoModel {
        val sunToUpdate = sunInfoRepository.findById(sunId).get()
        return sunInfoRepository.save(
            sunToUpdate.copy(
                sunName = body.sunName,
                stDist = body.stDist,
                stOptmag = body.stOptmag,
                stTeff = body.stTeff,
                stMass = body.stMass,
                stRad = body.stRad
            )
        )
    }

    @Transactional
    fun remove(sId: Int) {
        sunInfoRepository.deleteById(sId)
    }

}
