package hft.db2.kepler.controller

import hft.db2.kepler.model.PlanetSizeInfo
import hft.db2.kepler.service.PlanetSizeInfoService
import org.springframework.web.bind.annotation.*

@RestController
class PlanetSizeInfoController(
    val planetSizeInfoService: PlanetSizeInfoService
) {

    @RequestMapping(value = ["/planetsize"], method = [RequestMethod.GET])
    fun getAllPlanetSizeInfos(@RequestParam page: Int?, @RequestParam maxResults: Int?): List<PlanetSizeInfo> {
        return planetSizeInfoService.getAllPlanetSizeInfo(page, maxResults)
    }

    @RequestMapping(value = ["/planetsize/{pId}"], method = [RequestMethod.GET])
    fun getPlanetSizeInfoForPlanet(@PathVariable pId: Int): PlanetSizeInfo {
        return planetSizeInfoService.findByPlanetId(pId)
    }

    @RequestMapping(value = ["/planetsize/{pId}"], method = [RequestMethod.POST])
    fun create(@RequestBody body: PlanetSizeInfo, @PathVariable pId: Int): PlanetSizeInfo {
        return planetSizeInfoService.create(body, pId)
    }

    @RequestMapping(value = ["/planetsize/{psId}/"], method = [RequestMethod.PUT])
    fun update(@RequestBody body: PlanetSizeInfo, @PathVariable psId: Int): PlanetSizeInfo {
        return planetSizeInfoService.update(body, psId)
    }

    @RequestMapping(value = ["/planetsize/{psId}"], method = [RequestMethod.DELETE])
    fun remove(@PathVariable psId: Int) {
        planetSizeInfoService.remove(psId)
    }

}
