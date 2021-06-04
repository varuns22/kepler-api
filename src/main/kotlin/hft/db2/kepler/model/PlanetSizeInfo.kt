package hft.db2.kepler.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "planet_size_info")
data class PlanetSizeInfo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @OneToOne
    @JoinColumn(name = "planet_id", referencedColumnName = "planet_id")
    val planet: PlanetPlanetModel?,

    @Column(name = "pl_bmassj")
    val plBmassj: Double?,

    @Column(name = "pl_bmassjlim")
    val plBmassjlim: Double?,

    @Column(name = "pl_bmassprov")
    val plBmassprov: String?,

    @Column(name = "pl_radj")
    val plRadj: String?,

    @Column(name = "pl_radjlim")
    val plRadjlim: String?,

    @Column(name = "pl_dens")
    val plDens: String?,

    @Column(name = "pl_denslim")
    val plDenslim: String?

) : Serializable
