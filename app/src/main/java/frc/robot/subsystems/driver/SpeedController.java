package frc.robot.subsystems.driver;

import edu.wpi.first.wpilibj.SpeedController;
import java.util.List;

public interface SpeedControllerType {

    List<SpeedController> getLeftControllers();
    List<SpeedController> getRightControllers();
} 