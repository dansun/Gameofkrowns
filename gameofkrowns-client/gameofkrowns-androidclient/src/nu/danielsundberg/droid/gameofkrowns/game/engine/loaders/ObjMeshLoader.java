package nu.danielsundberg.droid.gameofkrowns.game.engine.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.loaders.obj.ObjLoader;
import com.badlogic.gdx.utils.Array;

public class ObjMeshLoader extends SynchronousAssetLoader<Mesh, ObjMeshLoader.MeshParameter> {
	
	public ObjMeshLoader(FileHandleResolver resolver) {
		super(resolver);
	}

	public Mesh load(AssetManager assetManager, String fileName, MeshParameter parameter) {
		return ObjLoader.loadObj(resolve(fileName).read());
	}

	@SuppressWarnings("rawtypes")
	public Array<AssetDescriptor> getDependencies (String fileName, MeshParameter parameter) {
		return null;
	}

	static public class MeshParameter extends AssetLoaderParameters<Mesh> {
	}

}
