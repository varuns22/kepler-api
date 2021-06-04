package hft.db2.kepler.controller

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import hft.db2.kepler.model.PlanetOrbitInfo
import hft.db2.kepler.service.PlanetOrbitInfoService
import org.springframework.web.bind.annotation.*

@RestController
class PlanetOrbitInfoController(
    val planetOrbitInfoService: PlanetOrbitInfoService
) {

    @RequestMapping(value = ["/planetorbit"], method = [RequestMethod.GET])
    @JsonIgnoreProperties("planetsWithSun")
    fun getAllPlanetOrbitInfo(@RequestParam page: Int?, @RequestParam maxResults: Int?): List<PlanetOrbitInfo> {
        return planetOrbitInfoService.getAllPlanetOrbit(page, maxResults)
    }

    @RequestMapping(value = ["/planetorbit/{pId}"], method = [RequestMethod.GET])
    @JsonIgnoreProperties("planetsWithSun")
    fun getPlanetOrbitByPlanetId(@PathVariable pId: Int): PlanetOrbitInfo {
        return planetOrbitInfoService.getPlanetOrbitByPlanetId(pId)
    }

    @RequestMapping(value = ["/planetorbit/{pId}"], method = [RequestMethod.POST])
    fun create(@RequestBody body: PlanetOrbitInfo, @PathVariable pId: Int): PlanetOrbitInfo {
        return planetOrbitInfoService.create(body, pId)
    }

    @RequestMapping(value = ["/planetorbit/{pId}"], method = [RequestMethod.PUT])
    fun update(@RequestBody body: PlanetOrbitInfo, @PathVariable pId: Int): PlanetOrbitInfo {
        return planetOrbitInfoService.update(body, pId)
    }

    @RequestMapping(value = ["/planetorbit/{poId}"], method = [RequestMethod.DELETE])
    fun remove(@PathVariable poId: Int) {
        planetOrbitInfoService.remove(poId)
    }
}
