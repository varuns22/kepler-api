package hft.db2.kepler.controller

import hft.db2.kepler.model.PlanetPlanetModel
import hft.db2.kepler.service.PlanetPlanetService
import org.springframework.web.bind.annotation.*

@RestController
class PlanetPlanetController(
    val planetPlanetService: PlanetPlanetService
) {

    @RequestMapping(value = ["/planets"], method = [RequestMethod.GET])
    fun getAllPlanetPlanet(@RequestParam page: Int?, @RequestParam maxResults: Int?): List<PlanetPlanetModel> {
        return planetPlanetService.getAllPlanetPlanet(page, maxResults)
    }

    @RequestMapping(value = ["/planets"], method = [RequestMethod.POST])
    fun create(@RequestBody body: PlanetPlanetModel): PlanetPlanetModel {
        return planetPlanetService.create(body)
    }

    @RequestMapping(value = ["/planets/{pId}"], method = [RequestMethod.PUT])
    fun update(@RequestBody body: PlanetPlanetModel, @PathVariable pId: Int): PlanetPlanetModel {
        return planetPlanetService.update(body, pId)
    }

    @RequestMapping(value = ["/planets/{pId}"], method = [RequestMethod.DELETE])
    fun remove(@PathVariable pId: Int) {
        planetPlanetService.remove(pId)
    }

}
