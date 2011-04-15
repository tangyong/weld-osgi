package com.sample.osgi.paint;

import com.sample.osgi.paint.gui.PaintFrame;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.environment.osgi.api.extension.events.BundleContainerInitialized;
import org.jboss.weld.environment.osgi.api.extension.events.Invalid;
import org.jboss.weld.environment.osgi.api.extension.events.Valid;

@ApplicationScoped
public class App {

    @Inject PaintFrame frame;

    public void onStartup(@Observes BundleContainerInitialized event) {
        System.out.println("CDI Container for bundle "
                + event.getBundleContext().getBundle() + " started");
        frame.start();
    }

    public void validListen(@Observes Valid valid) {
        frame.start();
    }

    public void invalidListen(@Observes Invalid valid) {
        frame.stop();
    }
}
