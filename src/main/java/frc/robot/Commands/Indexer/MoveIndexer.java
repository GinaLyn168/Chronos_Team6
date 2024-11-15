package frc.robot.Commands.Indexer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Indexer;

public class MoveIndexer extends Command {
    private final Indexer s_indexer;
    private Indexer.IndexerStates state;

    public MoveIndexer(Indexer.IndexerStates state) {
        s_indexer = Indexer.getInstance();
        this.state = state;
    }

    @Override
    public void initialize() {
        s_indexer.setSpeed(state);
    }

    @Override
    public void execute() {
        //Nothing
    }

    @Override
    public void end(boolean Interrupted) {
        s_indexer.setSpeed(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
