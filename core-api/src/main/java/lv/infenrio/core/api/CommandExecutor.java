package lv.infenrio.core.api;

import lv.infenrio.core.api.commands.DomainCommand;
import lv.infenrio.core.api.commands.DomainCommandResult;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);

}
