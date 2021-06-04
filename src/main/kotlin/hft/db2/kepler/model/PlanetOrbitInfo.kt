package hft.db2.kepler.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "planet_orbit_info")
data class PlanetOrbitInfo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @OneToOne
    @JoinColumn(name = "planet_id", referencedColumnName = "planet_id")
    val planet: PlanetPlanetModel?,

    @OneToOne
    @JoinColumn(name = "sun_name", referencedColumnName = "sun_name")
    @JsonIgnoreProperties("planetsWithSun")
    val sun: SunInfoModel?,

    @Column(name = "pl_orbper")
    val plOrbper: Double?,

    @Column(name = "pl_orbperlim")
    val plOrbperlim: Double?,

    @Column(name = "pl_orbsmax")
    val plOrbsmax: Double?,

    @Column(name = "pl_orbsmaxlim")
    val plOrbsmaxlim: Double?,

    @Column(name = "pl_orbeccen")
    val plOrbeccen: Double?,

    @Column(name = "pl_orbeccenlim")
    val plOrbeccenlim: Double?,

    @Column(name = "pl_orbincl")
    val plOrbincl: Double?,

    @Column(name = "pl_orbincllim")
    val plOrbincllim: String?

) : Serializable




