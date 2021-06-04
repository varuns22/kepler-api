package hft.db2.kepler.controller

import hft.db2.kepler.model.SunInfoModel
import hft.db2.kepler.service.SunInfoService
import org.springframework.web.bind.annotation.*

@RestController
class SunInfoController(
    val sunInfoService: SunInfoService
) {

    @RequestMapping(value = ["/suns"], method = [RequestMethod.GET])
    fun getAllSunInfo(@RequestParam page: Int?, @RequestParam maxResults: Int?): List<SunInfoModel> {
        return sunInfoService.getAllSunInfo(page, maxResults)
    }

    @RequestMapping(value = ["/sun-names"], method = [RequestMethod.GET])
    fun getAllSunNames(@RequestParam page: Int?, @RequestParam maxResults: Int?): List<String> {
        return sunInfoService.getAllSunNames(page, maxResults)
    }

    @RequestMapping(value = ["/suns"], method = [RequestMethod.POST])
    fun create(@RequestBody body: SunInfoModel): SunInfoModel {
        return sunInfoService.create(body)
    }

    @RequestMapping(value = ["/suns/{sunId}"], method = [RequestMethod.PUT])
    fun update(@RequestBody body: SunInfoModel, @PathVariable sunId: Int): SunInfoModel {
        return sunInfoService.update(body, sunId)
    }

    @RequestMapping(value = ["/suns/{sunId}/planets"], method = [RequestMethod.GET])
    fun getAllPlanetsForSun(@PathVariable sunId: Int): SunInfoModel {
        return sunInfoService.getAllPlanetsForSun(sunId)
    }

    @RequestMapping(value = ["/suns/{sId}"], method = [RequestMethod.DELETE])
    fun remove(@PathVariable sId: Int) {
        sunInfoService.remove(sId)
    }


}
