package se.chalmers.kangaroo.model.item;

import se.chalmers.kangaroo.model.Item;
import se.chalmers.kangaroo.model.Kangaroo;

/**
 * The item with the doublejump-effect.
 * @author simonal
 *
 */
public class DoubleJumpItem implements Item {
	
	public DoubleJumpItem() {
		
	}
	
	@Override
	public void onPickup(Kangaroo k) {
		;
	}

	@Override
	public void onDrop(Kangaroo k) {
		k.disableDoubleJump();
		k.removeItem();
		
	}

	@Override
	public void onUse(Kangaroo k) {
		k.enableDoubleJump();
		
	}

}
