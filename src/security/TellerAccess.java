package security;

public class TellerAccess implements AccessStrategy
{
    @Override
    public boolean canProcessTransaction() {
        return false;
    }

    @Override
    public boolean canViewReports() {
        return false;
    }

    @Override
    public boolean canAddPalance() {
        return false;
    }

    @Override
    public boolean canSubPalance() {
        return false;
    }

    @Override
    public boolean changeState() {
        return false;
    }
}