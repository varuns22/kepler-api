package hft.db2.kepler.model

import com.fasterxml.jackson.annotation.JsonBackReference
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "planet_planet")
data class PlanetPlanetModel(

    @Id
    @Column(name = "planet_id")
    val planetId: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sun_name", referencedColumnName = "sun_name")
    @JsonBackReference
    val sun: SunInfoModel?,

    @Column(name = "pl_letter")
    val plLetter: String?,

    @Column(name = "pl_discmethod")
    val plDiscmethod: String?,

    @Column(name = "pl_pnum")
    val plPnum: Double?,

    @Column(name = "pl_ttvflag")
    val plTtvflag: Double?,

    @Column(name = "pl_kepflag")
    val plKepflag: Double?,

    @Column(name = "pl_k2flag")
    val plK2flag: Double?,

    @Column(name = "pl_nnotes")
    val plNnotes: Double?,

    @Column(name = "ra_str")
    val raStr: String?,

    @Column(name = "ra")
    val ra: Double?,

    @Column(name = "declin_str")
    val declinStr: String?,

    @Column(name = "declin")
    val declin: Double?
) : Serializable
