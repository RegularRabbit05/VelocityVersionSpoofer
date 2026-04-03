package github.regularrabbit05.velocityVersionSpoofer;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.server.ServerPing;

@Plugin(id = "velocityversionspoofer", name = "VelocityVersionSpoofer", version = "1.0-SNAPSHOT", description = "Fix the Incompatible Version message", url = "https://regdev.me", authors = {"RegularRabbit05"})
public class ProxyPlugin {
    @Subscribe()
    public void onProxyPing(ProxyPingEvent event) {
        final int clientVer = event.getConnection().getProtocolVersion().getProtocol();
        if (clientVer == -1) return;
        final ServerPing oldPing = event.getPing();
        final ServerPing.Version ver = new ServerPing.Version(clientVer, oldPing.getVersion().getName());
        event.setPing(oldPing.asBuilder().version(ver).build());
    }
}
