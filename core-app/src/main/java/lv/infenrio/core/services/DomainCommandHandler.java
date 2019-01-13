package lv.infenrio.core.services;

import lv.infenrio.core.api.commands.DomainCommand;
import lv.infenrio.core.api.commands.DomainCommandResult;

public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command);

    Class getCommandType();

}
