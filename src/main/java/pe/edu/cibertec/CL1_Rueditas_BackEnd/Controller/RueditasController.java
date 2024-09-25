package pe.edu.cibertec.CL1_Rueditas_BackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.CL1_Rueditas_BackEnd.DTO.RueditasRequestDTO;
import pe.edu.cibertec.CL1_Rueditas_BackEnd.DTO.RueditasResponseDTO;
import pe.edu.cibertec.CL1_Rueditas_BackEnd.Service.RueditasService;

import java.io.IOException;

@RestController
@RequestMapping("/vehiculo")
public class RueditasController {

    @Autowired
    RueditasService rueditasService;

    @PostMapping("/inicio")
    public RueditasResponseDTO buscarVehiculo(@RequestBody RueditasRequestDTO rueditasRequestDTO){
        try{
            String[] datosVehi = rueditasService.validarPlaca(rueditasRequestDTO);
            if(datosVehi == null){
                return new RueditasResponseDTO("01", "Error: Vehiculo no Encontrado",
                        "", "", "", "", "");
            }
            return new RueditasResponseDTO("00", "", datosVehi[0], datosVehi[1],
                    datosVehi[2], datosVehi[3], datosVehi[4]);
        } catch (IOException e) {
            return new RueditasResponseDTO("99", "Error: Ocurrió un problema", "",
                    "", "", "", "");
        }
    }

}
