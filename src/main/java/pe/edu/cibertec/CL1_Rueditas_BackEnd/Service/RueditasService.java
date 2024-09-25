package pe.edu.cibertec.CL1_Rueditas_BackEnd.Service;

import pe.edu.cibertec.CL1_Rueditas_BackEnd.DTO.RueditasRequestDTO;

import java.io.IOException;

public interface RueditasService {
    String[] validarPlaca(RueditasRequestDTO rueditasRequestDTO) throws IOException;
}
