package frc.robot.Commands.Indexer;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Indexer;

public class MoveIndexer extends Command {
    private final Indexer s_indexer;
    private Indexer.IndexerStates state;
    private double time;
    private Timer timer;

    public MoveIndexer(Indexer.IndexerStates state, double time) {
        s_indexer = Indexer.getInstance();
        this.state = state;
        timer = new Timer();
        this.time = time;
    }

    @Override
    public void initialize() {
        s_indexer.setSpeed(state);
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        //Nothing
    }

    @Override
    public void end(boolean Interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
