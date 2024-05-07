package svenhjol.charm.feature.clear_item_frames;

import svenhjol.charm.foundation.feature.Network;

public final class ClientNetworking extends Network<ClearItemFramesClient> {
    public ClientNetworking(ClearItemFramesClient feature) {
        super(feature);
    }

    @Override
    public void onRegister() {
        var registry = feature.registry();
        registry.packetReceiver(CommonNetworking.AddAmethyst.TYPE,
            ClearItemFramesClient::handleAddToItemFrame);
        registry.packetReceiver(CommonNetworking.RemoveAmethyst.TYPE,
            ClearItemFramesClient::handleRemoveFromItemFrame);
    }
}