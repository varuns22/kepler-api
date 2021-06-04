package hft.db2.kepler.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "sun_info")
data class SunInfoModel(

    @Id
    val sId: Int,

    @Column(name = "sun_name")
    val sunName: String,

    @OneToMany(mappedBy = "sun", fetch = FetchType.LAZY)
    @JsonManagedReference
    val planetsWithSun: List<PlanetPlanetModel>?,

    @Column(name = "st_dist")
    val stDist: Double?,

    @Column(name = "st_optmag")
    val stOptmag: Double?,

    @Column(name = "st_teff")
    val stTeff: Double?,

    @Column(name = "st_mass")
    val stMass: Double?,

    @Column(name = "st_rad")
    val stRad: Double?
) : Serializable
