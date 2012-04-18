package se.chalmers.kangaroo.model;
/**
 * The item with the doublejump-effect.
 * @author twist3r
 *
 */
public class DoubleJumpItem implements Item {

	@Override
	public void onPickup(Kangaroo k) {
		k.setItem(this);
		
	}

	@Override
	public void onDrop(Kangaroo k) {
		k.disableDoubleJump();
		k.setItem(null);
		
	}

	@Override
	public void onUse(Kangaroo k) {
		k.enableDoubleJump();
		
	}

}